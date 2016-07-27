Вот есть билдер фильтров(FilterParamList), надо напихать в неё разных полей с условями фильтрации(FilterParam)
Билдер может быть составлен из значений и из списка значений. Надо универсализировать метод add по типу: F[F[_]]
F[_] - значение или лист значений или ещё всё что угодно.

  Поразмышлять на тему: будет ли это оверкодом овер абстракцией?

case class FilterParam(id: String, value: Any)

case class FilterParamList(params: Seq[FilterParam] = Seq()) {
  def add[A](id: String, value: Option[A]) = {
    value match {
      case Some(v) => FilterParamList(params ++ Seq(FilterParam(id, v)))
      case None => this
    }
  }

  def add[A](id: String, values: Seq[A]) = {
    FilterParamList(params ++ values.map(v => FilterParam(id, v)))
  }

  def map[B](f: FilterParam => B) = params.map(f)
}