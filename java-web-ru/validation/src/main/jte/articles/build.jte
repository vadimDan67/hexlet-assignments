@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page = null

@template.layout.page (
  content = @`
  @if (page != null)
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif
  @endif

  <form action="/articles" method="post">
    <div>
      <label>
        Заголовок
        <input type="text" name="title" value="${page.getTitle()}" />
      </label>
    </div>
    <div>
      <label for="content">Cодержание:</label>
      <textarea id="content" required name="content" value="${page.getTitle()}" > 
           ${page.getContent()}
      </textarea>
    </div>
    <input type="submit" value="Зарегистрировать" />
  </form>
`
)