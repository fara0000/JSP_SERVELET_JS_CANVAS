<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="lab2.models.TableRow" %>
<%@ page import="java.util.List" %>
<%
    List<TableRow> tableRows = (List<TableRow>) session.getAttribute("tableRows");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div id="root">
        <header>
            <p>
                <strong>Л/Р №2 по Веб-программированию</strong>
            </p>
            <p>
                <strong>Фахри Иманзаде Рашид оглы</strong>
            </p>
            <p>
                <strong>P3212 Вариант: 3156</strong>
            </p>
        </header>
        <div class="main">
            <div id="visualization_container" class="column">
                <canvas width="320px" height="320px" id="areas"></canvas>
            </div>
            <form id="form" name="form" action="checkPoints" method="GET">
                <p>Выберите X:</p>
                <div class="form__container" id="form__input__wrapper">
                    <input
                            type="text"
                            maxlength="6"
                            class="x_input"
                            id="form__input"
                            placeholder="choose a number between (-5,3)"
                            name = "coordinate_x"
                            autocomplete="off"
                    />
                </div>
                <p>Выберите Y:</p>
                <div class="button_block">
                    <button type="button" class="y_button" id="y_-2.0" onclick="changeY('-2.0')">-2.0
                    </button>
                    <button type="button" class="y_button" id="y_-1.5" onclick="changeY('-1.5')">-1.5
                    </button>
                    <button type="button" class="y_button" id="y_-1.0" onclick="changeY('-1.0')">-1.0
                    </button>
                    <button type="button" class="y_button" id="y_-0.5" onclick="changeY('-0.5')">-0.5
                    </button>
                    <button type="button" class="y_button" id="y_0" onclick="changeY('0')">0
                    </button>
                    <button type="button" class="y_button" id="y_0.5" onclick="changeY('0.5')">0.5
                    </button>
                    <button type="button" class="y_button" id="y_1.0" onclick="changeY('1.0')">1.0
                    </button>
                    <button type="button" class="y_button" id="y_1.5" onclick="changeY('1.5')">1.5
                    </button>
                    <button type="button" class="y_button" id="y_2.0" onclick="changeY('2.0')">2.0
                    </button>
                    <input type="hidden" id="y_select" name="coordinate_y">
                </div>
                <p>Выберите R:</p>
                <div class="form__container" id="form__radio__wrapper">
                    <label class="radio-button">
                        <input type = "radio" class="radio_input" name="r" value = "1" onclick="getRValue('1')">
                        <span class="label-visible">
                            <span class="fake-radiobutton"></span>
                            <p class="radio_button_text">1</p>
                        </span>
                    </label>
                    <label class="radio-button">
                        <input type = "radio" class="radio_input" name="r" value = "2" onclick="getRValue('2')">
                        <span class="label-visible">
                            <span class="fake-radiobutton"></span>
                            <p class="radio_button_text">2</p>
                        </span>
                    </label>
                    <label class="radio-button">
                        <input type = "radio" class="radio_input" name="r" value = "3" onclick="getRValue('3')">
                        <span class="label-visible">
                            <span class="fake-radiobutton"></span>
                            <p class="radio_button_text">3</p>
                        </span>
                    </label>
                    <label class="radio-button">
                        <input type = "radio" class="radio_input" name="r" value = "4" onclick="getRValue('4')">
                        <span class="label-visible">
                            <span class="fake-radiobutton"></span>
                            <p class="radio_button_text">4</p>
                        </span>
                    </label>
                    <label class="radio-button">
                        <input type = "radio" class="radio_input" name="r" value = "5" onclick="getRValue('5')">
                        <span class="label-visible">
                            <span class="fake-radiobutton"></span>
                            <p class="radio_button_text">5</p>
                        </span>
                    </label>
                    <input type="hidden" id="r_select" name="coordinate_r" value="">
                </div>
                <div class="form__container" id="check__button__wrapper">
                    <button type="submit" id="check__button">Проверить!</button>
                </div>
            </form>
            <div class="table_container result_table">
                <table>
                    <tr>
                        <th>X</th>
                        <th>Y</th>
                        <th>R</th>
                        <th>Время запуска</th>
                        <th>Время работы</th>
                        <th>Результат</th>
                    </tr>
                    <%
                        if (tableRows != null)
                            for (TableRow tableRow : tableRows) {
                    %>
                    <tr>
                        <td class="x_cell">
                            <%= tableRow.getX() %>
                        </td>
                        <td class="y_cell">
                            <%= tableRow.getY() %>
                        </td>
                        <td class="r_cell">
                            <%= tableRow.getR() %>
                        </td>
                        <td>
                            <%= tableRow.getCurrentTime() %>
                        </td>
                        <td>
                            <%= tableRow.getTime() %>
                        </td>
                        <td>
                            <%= tableRow.getResult() %>
                        </td>
                    </tr>
                    <%}%>
                </table>
            </div>
        </div>
        <footer class="footer">
            <div class="footer_text">
                Санкт-Петербург, ИТМО
            </div>
        </footer>
        </div>
    </div>
<script src="js/index.js"></script>
<script src="js/canvas.js"></script>
</body>
</html>