$(function () {
    var tabContainers = $('div.slider_tab > div'); // получаем массив контейнеров
    tabContainers.hide().filter(':first').show(); // прячем все, кроме первого
    // далее обрабатывается клик по вкладке
    $('div.slider_block .title a').click(function () {
        tabContainers.hide(); // прячем все табы
        tabContainers.filter(this.hash).show() // показываем содержимое текущего
        $('div.slider_block .title a').removeClass('active'); // у всех убираем класс 'selected'
        $(this).addClass('active'); // текушей вкладке добавляем класс 'selected'
        return false;
    }).filter(':first').click();
});
$(function () {
    var tabContainers = $('div.slider_tab > div'); // получаем массив контейнеров
    tabContainers.hide().filter(':first').show(); // прячем все, кроме первого
    // далее обрабатывается клик по вкладке
    $('div.slider_block .title a').click(function () {
        tabContainers.hide(); // прячем все табы
        tabContainers.filter(this.hash).show() // показываем содержимое текущего
        $('div.slider_block .title a').removeClass('active'); // у всех убираем класс 'selected'
        $(this).addClass('active'); // текушей вкладке добавляем класс 'selected'
        return false;
    }).filter(':first').click();
});