<%@include file="parts/header.jsp" %>
<div class="container">
    <h1>Header</h1>
    <b>message: ${sessionScope.question.text}</b>

    <button onclick="restart()">Start again</button>

    <button onclick="restart()">Start again</button>

    <br>

    <script>
        function restart() {
            $.ajax({
                url: '/restart',
                type: 'POST',
                contentType: 'application/json;charset=UTF-8',
                async: false,
                success: function () {
                    location.reload();
                }
            });
        }
    </script>
</div>
<%@include file="parts/footer.jsp" %>
