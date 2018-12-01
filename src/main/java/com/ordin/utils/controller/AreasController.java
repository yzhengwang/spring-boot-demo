package com.ordin.utils.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ordin.utils.entity.Areas;
import com.ordin.utils.service.AreasService;
import com.ordin.utils.utils.ResultFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * <p>
 * 地区信息 前端控制器
 * </p>
 *
 * @author yzhengwang
 * @since 2018-11-30
 */
@RestController
@RequestMapping(value = "areas")
public class AreasController {

    @Autowired
    private AreasService areasService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public Object index() {
        QueryWrapper<Areas> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("*");
        List<Areas> list = areasService.list(queryWrapper.orderByAsc("id"));
        if (list.size() > 0) {
            return ResultFormat.success(list);
        }
        return ResultFormat.error();
    }
}
