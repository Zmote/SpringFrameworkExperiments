package ch.zmotions.controller;

import ch.zmotions.domain.UserEO;
import ch.zmotions.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {

    @Autowired
    UserRepository userRepository;
    Integer ageFilterParam;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(){
        return "redirect:/users";
    }

    @RequestMapping(value="/users", method = RequestMethod.GET)
    public String showUsers(Model model,String ageFilter){
        if(ageFilter == null){
            model.addAttribute("users", userRepository.fullFetch());
            return "index";
        }else{
            ageFilterParam = new Integer(ageFilter);
            model.addAttribute("users", userRepository.filterAgeFullFetchWith(new Integer(ageFilterParam)));
            return "index :: content";
        }
    }

    @RequestMapping(value="/users", method = RequestMethod.POST)
    public String addNewUser(Model model, UserEO user, HttpServletResponse response){
        userRepository.save(user);
        if(ageFilterParam == null){
            model.addAttribute("users", userRepository.fullFetch());
        }else{
            model.addAttribute("users", userRepository.filterAgeFullFetchWith(ageFilterParam));
        }
        return "index :: content";
    }

}
