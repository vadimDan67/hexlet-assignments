@import exercise.util.NamedRoutes
@import exercise.dto.MainPage
@param MainPage page = null


@template.layout.page(
    content = @`
        @if (page != null)
            <h1>${page.getName()}</h1>
            <h2><a href="${NamedRoutes.logoutPath()}">Выйти</a></h2>
        @else
            <h1><a href="${NamedRoutes.buildSessionPath()}">Войти</a></h1>
        @endif
    `
)