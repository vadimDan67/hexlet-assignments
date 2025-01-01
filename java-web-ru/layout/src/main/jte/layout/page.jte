@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Hexlet Javalin Example</title>
    </head>
    <body>
        <header>
            <a href="/">Главная страница</a>
            <a href="/users">Users</a>
        </header>
        ${content}
        <footer>
            <p>© 2018 Gandalf</p>
        </footer>
        
    </body>
</html>
