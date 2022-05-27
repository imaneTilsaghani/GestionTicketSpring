package g3.g10.devoir.mvccontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import g3.g10.devoir.models.User;
import g3.g10.devoir.services.UserService;
import g3.g10.devoir.utils.Constants;

@Controller
public class HomeController {
	@Autowired
	private UserService<User> userService;
	
    @RequestMapping("/")
	public String index(Model model, Authentication auth) {
        model.addAttribute("msg", "Hello World");
        User user = userService.findByEmail(auth.getName());
        model.addAttribute("admin", user.getRole().equals(Constants.getRole("admin")));
        model.addAttribute("client", user.getRole().equals(Constants.getRole("client")));
        model.addAttribute("dev", user.getRole().equals(Constants.getRole("dev")));
        model.addAttribute("id", user.getId());
        model.addAttribute("name", user.getDisplayName());

		return "index";
	}
}
