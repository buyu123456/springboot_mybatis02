package com.gj.springboot_mybatis02.handler;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gj.springboot_mybatis02.dao.StudentDao;
import com.gj.springboot_mybatis02.po.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * @author kuass
 * @create kuass-04-12-17:04
 */
@Controller
public class StudentHandler {
    @Resource
    private StudentDao sd;

    /*@RequestMapping("/")
    public String findAll(Model model, Integer pageNum){
        if(pageNum == null){
            pageNum = 1;
        }
        *//*第一个参数代表是第几页，第二个参数代表每页显示几条数据*//*
        PageHelper.startPage(pageNum,8);
        List<Student> list = sd.findAll();
        //获取总页数
        PageInfo pageInfo = new PageInfo(list);
        int pages = pageInfo.getPages();
        model.addAttribute("list",list);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("pages",pages);
        return "findAll";
    }*/


    @RequestMapping("/")
    public String findAll(Map<String,Object> map,Integer pageNum){
        if(pageNum == null){
            pageNum = 1;
        }
        PageHelper.startPage(pageNum,5);
        List<Student> list = sd.findAll();
        PageInfo pageInfo = new PageInfo(list);
        int pages = pageInfo.getPages();
        map.put("list",list);
        map.put("pageNum",pageNum);
        map.put("pages",pages);
        return "FindAll";
    }


    @RequestMapping("/findById")
    public String findById(int id,Map<String,Object> map){
        Student student = sd.findById(id);
        map.put("stulist",student);
        return "update";
    }

    @RequestMapping("/insert")
    public String insert(Student student){
        sd.insert(student);
        return "redirect:/";
    }

    @RequestMapping("/delete")
    public String delete(int id){
        sd.delete(id);
        return "redirect:/";
    }
    @RequestMapping("/update")
    public String update(Student student){
        sd.update(student);
        return "redirect:/";
    }
    @RequestMapping("insert.to")
    public String inserts(){
        return "Insert";
    }

}
