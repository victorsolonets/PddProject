$(function () {
    var tabContainers = $('div.slider_tab > div'); // �������� ������ �����������
    tabContainers.hide().filter(':first').show(); // ������ ���, ����� �������
    // ����� �������������� ���� �� �������
    $('div.slider_block .title a').click(function () {
        tabContainers.hide(); // ������ ��� ����
        tabContainers.filter(this.hash).show() // ���������� ���������� ��������
        $('div.slider_block .title a').removeClass('active'); // � ���� ������� ����� 'selected'
        $(this).addClass('active'); // ������� ������� ��������� ����� 'selected'
        return false;
    }).filter(':first').click();
});
$(function () {
    var tabContainers = $('div.slider_tab > div'); // �������� ������ �����������
    tabContainers.hide().filter(':first').show(); // ������ ���, ����� �������
    // ����� �������������� ���� �� �������
    $('div.slider_block .title a').click(function () {
        tabContainers.hide(); // ������ ��� ����
        tabContainers.filter(this.hash).show() // ���������� ���������� ��������
        $('div.slider_block .title a').removeClass('active'); // � ���� ������� ����� 'selected'
        $(this).addClass('active'); // ������� ������� ��������� ����� 'selected'
        return false;
    }).filter(':first').click();
});