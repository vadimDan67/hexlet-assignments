@import exercise.dto.users.UsersPage
@param UsersPage page

<html lang="en">
    <head>
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1" />
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
              crossorigin="anonymous">
      <title>Hexlet Users</title>
    </head>
    <body>
        @if(page.getUsers().isEmpty())
            <p>Пока не добавлено ни одного курса</p>
        @else
            @for(var user : page.getUsers())
               <div>
                   <h2><a href="/courses/${user.getId()}">${user.getFirstName()}</a></h2>
                   <p>${user.getLastName()}</p>
                   <p>${user.getEmail()}</p>
               </div>
            @endfor
        @endif
    </body>
</html>