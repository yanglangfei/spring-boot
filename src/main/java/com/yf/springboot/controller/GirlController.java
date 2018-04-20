package com.yf.springboot.controller;

import com.yf.springboot.model.TbGirl;
import com.yf.springboot.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    /**
     * 查询所有女孩
     * @return
     */
    @GetMapping("/girls")
    public String girlsList(Model model){
        List<TbGirl> girlList = girlRepository.findAll();
        model.addAttribute("girlList",girlList);
        return "index";
    }


    /**
     * 新增一个女孩
     * @param girl
     * @return
     */
    @PutMapping("/girl")
    @ResponseBody
    public  TbGirl putGirl(TbGirl girl){
        girl.setGmtCreate(new Date());
        girl.setGmtModified(new Date());
        return girlRepository.save(girl);
    }

    /**
     * 通过id获取girl
     * @param id
     * @return
     */
    @GetMapping("/{id}/girl")
    @ResponseBody
    public  TbGirl findOne(@PathVariable("id") Long id){
        return girlRepository.findById(id).get();
    }

    /**
     * 删除女生
     * @param id
     * @return
     */
    @DeleteMapping("/{id}/girl")
    @ResponseBody
    public  String  delGirl(@PathVariable("id") Long id){
        girlRepository.deleteById(id);
        return "删除成功";
    }

    /**
     * 更新女生资料
     * @param id
     * @param name
     * @param cupSize
     * @param imageHeader
     * @return
     */
    @PostMapping("/{id}/girl")
    @ResponseBody
    public  TbGirl updateGirl(@PathVariable("id") Long id,@RequestParam("name") String name,@RequestParam("cupSize") String cupSize,@RequestParam("imageHeader") String imageHeader){
        TbGirl tbGirl = girlRepository.getOne(id);
        tbGirl.setGmtModified(new Date());
        tbGirl.setCupSize(cupSize);
        tbGirl.setHeaderImage(imageHeader);
        tbGirl.setName(name);
        return girlRepository.save(tbGirl);
    }

    /**
     * 根据罩杯获取女生
     * @param cupSize
     * @return
     */
    @GetMapping("/{cupSize}/girls")
    @ResponseBody
    public  List<TbGirl> findGirlsByCupSize(@PathVariable("cupSize") String cupSize){
        return girlRepository.findTbGirlsByCupSize(cupSize);
    }





}
