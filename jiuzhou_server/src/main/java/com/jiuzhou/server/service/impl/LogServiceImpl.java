package com.jiuzhou.server.service.impl;

import com.jiuzhou.server.entity.Log;
import com.jiuzhou.server.mapper.LogMapper;
import com.jiuzhou.server.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author doro
 * @since 2023-03-06
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

}
