package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void page(Context ctx) {
        var page  = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var posts = PostRepository.findAll(page, 5);
        var pagePost = new PostsPage(page, posts);
        ctx.render("posts/index.jte", model("page", pagePost));
    }
    
    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Page not found."));
        var page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }
    // END
}
