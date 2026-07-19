package com.unihub.controller;

import com.unihub.entity.Resource;
import com.unihub.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/resources/add")
    public ModelAndView addResourcePage() {

        ModelAndView mav = new ModelAndView("add-resource");
        mav.addObject("resource", new Resource());
        return mav;
    }

    @PostMapping("/resources/add")
    public String saveResource(Resource resource) {
        resourceService.saveResource(resource);
        return "redirect:/resources";
    }

    @GetMapping("/resources")
    public ModelAndView viewResources() {

        ModelAndView mav = new ModelAndView("resources");
        mav.addObject("resources",
                resourceService.getAllResources());
        return mav;
    }

    @GetMapping("/resources/edit/{id}")
    public ModelAndView editResource(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("edit-resource");
        mav.addObject("resource",
                resourceService.getResourceById(id));
        return mav;
    }

    @PostMapping("/resources/update")
    public String updateResource(Resource resource) {
        resourceService.updateResource(resource);
        return "redirect:/resources";
    }

    @GetMapping("/resources/delete/{id}")
    public String deleteResource(@PathVariable Long id) {
        resourceService.deleteResource(id);
        return "redirect:/resources";
    }

}