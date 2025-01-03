package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    // BEGIN
    public static String postsPage() {
        return "/posts";
    }
    
    public static String postsPage(Integer page) {
        return postsPath(String.valueOf(page));
    }
    
    public static String postsPath(String page) {
        return "/posts?page=" + page;
    }
    
     public static String postPath(Long id) {
        return postsPath(String.valueOf(id));
    }
    
    public static String postPath(String id) {
        return "/post/" + id;
    }
    // END
}
