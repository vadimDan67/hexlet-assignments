@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page( 
    content = @`
        <div>
            <main>
              <a href="${NamedRoutes.postsPage()}">Посты</a>
            </main>
        </div 
        <p>${page.getPost().getName()}</p>
        <p>${page.getPost().getBody()}</p
    `
)