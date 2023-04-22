package com.vikas.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vikas.demo.dao.AlienRepo;
import com.vikas.demo.dao.AlienRepoJPA;
import com.vikas.demo.model.Alien;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	@Autowired
	AlienRepoJPA jsonrepo;
	
	@RequestMapping("/")
	public String aliencon() {
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);	
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mv = new ModelAndView("showalien.jsp");
			Alien alien=repo.findById(aid).orElse(new Alien());
			List<Alien> alien1=repo.findByTech("Java");
			System.out.println(alien1);
			List<Alien> alien2	=repo.findByAidGreaterThan(102);
			System.out.println(alien2);
		mv.addObject(alien);
		return mv;
	}
	
	@RequestMapping("/deleteAlien")
	public ModelAndView deleteAlien(@RequestParam int aid, Alien alien) {
		ModelAndView mv = new ModelAndView("deleteAlien.jsp");
			repo.deleteById(aid);
		mv.addObject(alien);
		return mv;
	}
	
	
	/*
	 * @RequestMapping("/Alien")
	 * @ResponseBody public String getAlienUsingRest() {
	 * 
	 * return repo.findAll().toString(); }
	 * 
	 * @RequestMapping("/Alien/{aid}")
	 * @ResponseBody public String getSpecificAlienUsingRest(@PathVariable("aid")
	 * int aid) {
	 * 
	 * return repo.findById(aid).toString(); }
	 * 
	 */
	
	@GetMapping(path="/Alien", produces = {"application/json"})
	@ResponseBody
	public List<Alien> getAlienUsingRestJson() {
		
		return jsonrepo.findAll();
	}
	
	@GetMapping("/Alien/{aid}")
	@ResponseBody
	public Optional<Alien> getSpecificAlienUsingRestJson(@PathVariable("aid") int aid) {
		
		return jsonrepo.findById(aid);
	}
	
	@PostMapping(path="/Alien", consumes = {"application/json"})
	@ResponseBody
	public Alien addAlienUsingRest(@RequestBody Alien alien) {
		jsonrepo.save(alien);	
		return alien;
	}

	@DeleteMapping(path="/Alien/{aid}", consumes = {"application/json"})
	@ResponseBody
	public String deleteAlienUsingRest(@PathVariable("aid") int aid) {
		jsonrepo.deleteById(aid);	
		return "deleted";
	}
	
	@PutMapping(path="/Alien", consumes = {"application/json"})
	@ResponseBody
	public Alien addOrUpdateUsingRest(@RequestBody Alien alien) {
		jsonrepo.save(alien);	
		return alien;
	}
	
}
