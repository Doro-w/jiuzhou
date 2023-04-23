<template>
  <div class="com-container">
    <el-table
        :data="devicesData"
        stripe
        style="border-radius: 6px;background-color: rgba(255,255,255,0)"
        :header-cell-style="{background:'rgba(1,49,176,0.88)',color:'rgb(255,255,255)'}"
        :cell-style="{background:'rgb(15,84,216)',color:'rgb(255,255,255)'}">
      <el-table-column
        prop="name"
        label="设备名称"
        align="center">
      </el-table-column>
      <el-table-column
          prop="type"
          label="设备型号"
          align="center">
      </el-table-column>
      <el-table-column
          prop="area"
          label="安装地区"
          align="center">
      </el-table-column>
      <el-table-column
          prop="state"
          label="工作状态"
          align="center"
          :formatter=FilterState>
      </el-table-column>
      <el-table-column
          prop="alarm"
          label="报警信息"
          align="center">
      </el-table-column>
    </el-table>

    <el-row :gutter="15">
      <el-col :span="12">
        <div class="grid-content bg-purple">
          设备总数：20台
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          工作中设备：18台
        </div>
      </el-col>
    </el-row>
  </div>

</template>

<script>
export default {
  name: "DeviceInfoTable",
  data(){
    return{
      devicesData: [],
      page: 1,
      pageSize: 7,
    }
  },
  methods:{
    async getAllDevice(page=1, pageSize=7) {
      let that = this;
      await that.$http.get('/device/queryAllDeviceByPage',{
        params:{
          page: page,
          pageSize: pageSize
        },
      }
      ).then((response)=>{
        // console.log(response)
        that.devicesData = response.data.result;
      }).catch((error)=>{
        console.log(error);
      })



    },
    FilterState(row) {
      return row.state === 0 ? "异常" : "正常";
    },
  },
  created(){
    this.getAllDevice();
  }
}
</script>

<style lang="less" scoped>
  .title {
    position: absolute;
    left: 50px;
    top: 20px;
    z-index: 999;
    color: rgba(255, 255, 255, 0.82);
    cursor: pointer;
    .before-icon {
      position: absolute;
      left: -20px;
    }
    .title-icon {
      margin-left: 10px;
    }
  }
  .el-table-column {
    width: 80px;
  }
  .el-row {
    margin-bottom: 20px;
  &:last-child {
     margin-bottom: 0;
   }
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #255fd2;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 30px;
    text-align: center;
    padding-top: 5px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
</style>