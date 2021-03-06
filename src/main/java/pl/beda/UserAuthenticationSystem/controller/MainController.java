package pl.beda.UserAuthenticationSystem.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.beda.UserAuthenticationSystem.component.mailer.SingUpMailer;
import pl.beda.UserAuthenticationSystem.entity.Item;
import pl.beda.UserAuthenticationSystem.entity.User;
import pl.beda.UserAuthenticationSystem.repository.UserRepository;
import pl.beda.UserAuthenticationSystem.service.ItemService;

@RestController
public class MainController {

    private static final int PAGE_SIZE = 3;

    @Autowired
    ItemService itemService;

    @Autowired
    private SingUpMailer mailer;

    @Autowired
    UserRepository userRepository;


    @RequestMapping("/")
    public List<Item> index(HttpServletResponse response) {
        return itemService.findByQuantityGreaterThanEqualOrderByQuantityDesc(250);
    }

    @RequestMapping("/quantity_treshold")
    public List<Item> quantityTreshold(@RequestParam(name = "quantity") Optional<Integer> quantityParam) {
        int quantity = 50;
        if (quantityParam.isPresent()) {
            quantity = quantityParam.get();
        }

        return itemService.getItemsWithQuantityOver(quantity);
    }

    @RequestMapping("/find_by_name")
    public List<Item> findByName() {
        String regexName = "s%";
        List<Item> result = itemService.getItemsWithNameLike(regexName);

        return result;
    }

    @RequestMapping("/items")
    public List<Item> items(@RequestParam(defaultValue = "0") String page) {
        int currentPage = Integer.parseInt(page);
        PageRequest pageRequest = PageRequest.of(currentPage, PAGE_SIZE);

        Page<Item> items = itemService.findAll(pageRequest);

        return items.getContent();
    }

    @RequestMapping("/send_mail")
    public String sendMail() {
        mailer.sendMessage("example@mail.com", "Mail topic!", "Mail body.");
        return "mail sent";
    }

    @RequestMapping("/confirm_email")
    public String confirmEmail(@RequestParam(name = "token") String token) {
        Optional<User> optionalUser = userRepository.findByConfirmationToken(token);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setEnabled(true);
            userRepository.save(user);
            return "Your account has been activated";
        } else {
            return "Given token does not exist";
        }
    }
}
