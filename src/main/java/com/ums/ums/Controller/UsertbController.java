package com.ums.ums.Controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ums.ums.Entity.Usertb;
import com.ums.ums.Service.IUsertbService;
import com.ums.ums.Service.Imp.UsertbServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wudi
 * @since 2022-01-12
 */
@Controller
@RequestMapping("/usertb")
public class UsertbController {

    private final IUsertbService usertbService;

    public UsertbController(IUsertbService usertbService) {
        this.usertbService = usertbService;
    }

    @GetMapping("/getUser")
    public String getUser(Model model){
        model.addAttribute("model",usertbService.list());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model){
        Usertb usertb = new Usertb();
        model.addAttribute("model",usertb);
        return "add";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("model",usertbService.getById(id));
        return "edit";
    }

    @PostMapping("/save")
    public String addUser(Usertb usertb){
        usertbService.save(usertb);
        return "redirect:/usertb/getUser";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        usertbService.removeById(id);
        return "redirect:/usertb/getUser";
    }

    @PostMapping("/update")
    public String update(Usertb usertb){
        Usertb existing = usertbService.getById(usertb.getID());
        existing.setComment(usertb.getComment());
        existing.setName(usertb.getName());
        usertbService.updateById(existing);
        return "redirect:/usertb/getUser";
    }




}

