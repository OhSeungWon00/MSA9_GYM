package com.gym.gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gym.gym.domain.Files;
import com.gym.gym.domain.TrainerProfile;
import com.gym.gym.service.FileService;
import com.gym.gym.service.TrainerProfileService;

import lombok.extern.slf4j.Slf4j;



/**
 * 목록         /board/list     [GET]
 * 조회         /board/select   [GET]
 * 등록         /board/insert   [GET]
 * 등록 처리    /board/insert   [POST]
 * 수정         /board/update   [GET]
 * 수정 처리    /board/update   [POST]
 * 삭제 처리    /board/delete   [POST]
*/
@Slf4j
@Controller
@RequestMapping("/admin/trainer")
public class TrainerProfileController {

    @Autowired
    private TrainerProfileService trainerProfileService;

    @Autowired
    private FileService fileService;
    
    /**
     * 목록
     * @return
     * @throws Exception 
    */
    @GetMapping("/list")
    public String list(Model model
                     , @RequestParam(name = "keyword", defaultValue = "") String keyword) throws Exception {
        List<TrainerProfile> trainerList = trainerProfileService.list(keyword);
        model.addAttribute("trainerList", trainerList);
        return "/admin/trainer/list";
    }
    
    /**
     * 조회
     * @param no
     * @return
     * @throws Exception 
    */
    @GetMapping("/select")
    public String select(Model model
                      , @RequestParam("no") int no
                      , Files file) throws Exception {
        
        // 프로필 조회
        TrainerProfile trainerProfile = trainerProfileService.select(no);
        model.addAttribute("trainerProfile", trainerProfile);


        // 파일 목록 조회
        file.setProfileNo(trainerProfile.getNo());

        log.info("file : " + file);
        List<Files> fileList = fileService.listByParent(file);
        model.addAttribute("fileList", fileList);

        return "/admin/trainer/select";
    }


    /**
     * 등록
     * @return
     */
    @GetMapping("/insert")
    public String insert() {

        return "/admin/trainer/insert";
    }
    
    /**
     * 등록 처리
     * @param trainerProfile
     * @return
     * @throws Exception 
    */
    @PostMapping("/insert")
    public String insertPost(TrainerProfile trainerProfile, Files file) throws Exception {
        int result = trainerProfileService.insert(trainerProfile);
        if( result > 0 ) {
            return "redirect:/admin/trainer/list";
        }
        return "redirect:/admin/trainer/insert?error";
    }
    
    /**
     * 수정
     * @param no
     * @return
     * @throws Exception 
    */
    @GetMapping("/update")
    public String update(Model model
                      , @RequestParam("no") int no
                      , Files file) throws Exception {
        // 게시글 조회
        TrainerProfile trainerProfile = trainerProfileService.select(no);
        model.addAttribute("trainerProfile", trainerProfile);

        // 파일 목록 조회
        file.setProfileNo(trainerProfile.getNo());

        log.info("file : " + file);
        List<Files> fileList = fileService.listByParent(file);
        model.addAttribute("fileList", fileList);

        return "/admin/trainer/update";
    }
    
    /**
     * 수정 처리
     * @param trainerProfile
     * @return
     * @throws Exception 
    */
    @PostMapping("/update")
    public String updatePost(TrainerProfile trainerProfile) throws Exception {
        int result = trainerProfileService.update(trainerProfile);
        if( result > 0 ) {
            return "redirect:/admin/trainer/list";
        }
        return "redirect:/admin/trainer/update?error";
    }
    
    // 삭제 처리
    @PostMapping("/delete")
    public String delete(@RequestParam("no") int no) throws Exception {
        int result = trainerProfileService.delete(no);
        if( result > 0 ) 
            return "redirect:/admin/trainer/list";
        return "redirect:/admin/trainer/update?error";
    }
    
}