@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <form action="/users" method="get">
            <input type="search" name="term" value="${page.getTerm()}">
            <input type="submit" value="Искать">
        </form>
        @if (page.getUsers().size() > 0)
            <h1>Пользователи</h1>
            <table class="table table-striped">
                @for(var user : page.getUsers())
                    <tr>
                        <td>
                            ${user.getId()}
                        </td>
                        <td>
                            ${user.getFirstName()} ${user.getLastName()}
                        </td>
                    </tr>
                @endfor
            </table>
        @endif
    `
)