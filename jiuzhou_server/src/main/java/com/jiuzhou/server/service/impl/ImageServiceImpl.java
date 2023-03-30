package com.jiuzhou.server.service.impl;

import com.jiuzhou.server.entity.Image;
import com.jiuzhou.server.mapper.ImageMapper;
import com.jiuzhou.server.service.ImageService;
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
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements ImageService {

}
