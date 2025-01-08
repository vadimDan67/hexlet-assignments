package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;
import exercise.util.NamedRoutes;

import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void index(Context ctx) {
        var user = ctx.sessionAttribute("currentUser");
        if (user != null) {
            var page = new MainPage(user.toString());
            ctx.render("index.jte", model("page", page));
        }
        else
        {
           ctx.render("index.jte");
        }
    }
    
    public static void build(Context ctx) {
        ctx.render("build.jte", model("page", new LoginPage()));
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var password = ctx.formParam("password");
        var user = UsersRepository.findByName(name).orElse(null);
        if (user != null && user.getPassword().equals(encrypt(password))) {
           ctx.sessionAttribute("currentUser", name);
           ctx.redirect(NamedRoutes.rootPath());
        }
        else {
           var page = new LoginPage(name,"Wrong username or password");
           ctx.render("build.jte", model("page",page));
        }
    }

    public static void delete(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
