@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page( 
    content = @`
        @if(page.getPosts().isEmpty())
            <p>Пока не добавлено ни одного пользователя</p>
        @else
            @for(var post : page.getPosts())
               <div>
                   <h2><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></h2>
               </div>
            @endfor
        @endif
        <div>
            <p><a href="${NamedRoutes.postsPage(page.getPage() - 1)}">Назад</a></p>
        </div>
        <div>
            <p><a href="${NamedRoutes.postsPage(page.getPage() + 1)}">Вперед</a></p>
        </div> 
        
    `   
)