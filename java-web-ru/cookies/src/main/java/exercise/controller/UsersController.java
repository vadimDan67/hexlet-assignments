package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) throws Exception {
        var firstName = ctx.formParamAsClass("firstName", String.class).get();
        var lastName = ctx.formParamAsClass("lastName", String.class).get();
        var email= ctx.formParamAsClass("email", String.class).get();
        var password = ctx.formParamAsClass("password", String.class).get();
        var user = new User(firstName, lastName, email, password, Security.generateToken());
        UserRepository.save(user);
        ctx.cookie("token", user.getToken());
        ctx.redirect(NamedRoutes.userPath(user.getId()));
    }
    
    public static void show(Context ctx) throws Exception {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("User not found"));
        var page = new UserPage(user);
        if (!user.getToken().equals( ctx.cookie("token"))) {
            ctx.render("users/build.jte");
        } else {
            ctx.render("users/show.jte", model("page", page));
        }
    };
    // END
}
