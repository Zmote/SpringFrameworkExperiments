package ch.zmotions.controller;

import ch.zmotions.domain.RoleEO;
import ch.zmotions.domain.UserEO;
import ch.zmotions.repository.RoleRepository;
import ch.zmotions.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class IndexController {

    // TODO: 05.11.2016 Fix refreshing issue after role save
    // TODO: 05.11.2016 Fix Sorting issue of users

    @Autowired UserRepository userRepository;
    @Autowired RoleRepository roleRepository;
    private Integer ageFilterParam;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(){
        return "redirect:/users";
    }

    @RequestMapping(value="/users", method = RequestMethod.GET)
    public String showUsers(Model model, String ageFilter){
        if(ageFilter !=null){
            ageFilterParam = new Integer(ageFilter);
        }
        setModel(model);
        return "index";
    }

    @RequestMapping(value="/users", method = RequestMethod.POST)
    public String addNewUser(Model model, UserEO user, HttpServletRequest request){
        userRepository.save(user);
        setModel(model);
        return "index :: content";
    }

    @RequestMapping(value="/users/{userid}", method = RequestMethod.POST)
    public String updateUser(Model model, String role, @PathVariable("userid") Long id){
        UserEO editedUser = userRepository.findByPk(id);
        editedUser.setRole(roleRepository.findByName(role));
        userRepository.save(editedUser);
        setModel(model);
        return index();
    }

    /**
     * Helper Method
    * @author Zafer Dogan
     *@return return index or content for list to fill
    * */
    private void setModel(Model model) {
        if(ageFilterParam == null){
            model.addAttribute("users", userRepository.fullFetch());
            model.addAttribute("roles",roleRepository.fullFetch());
        }else{
            ageFilterParam = new Integer(ageFilterParam);
            model.addAttribute("users", userRepository.filterAgeFullFetchWith(ageFilterParam));
            model.addAttribute("roles",roleRepository.fullFetch());
        }
    }

}
