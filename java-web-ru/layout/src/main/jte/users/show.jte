@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page( 
    content = @`
        <h1>${page.getUser().getFirstName()}</h1>
        <h2>${page.getUser().getLastName()}</h2>
        <p>${page.getUser().getEmail()}</p>
    `
)