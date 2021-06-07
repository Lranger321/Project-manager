$(document).ready(function () {

    $('.nBtn, .table .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text(); //return Edit

        if (text === 'Редактировать') {
            $.get(href, function (project, status) {
                $('.myForm #id').val(project.id);
                $('.myForm #name').val(project.name);
                $('.myForm #dateStart').val(project.dateStart);
                $('.myForm #dateEnd').val(project.dateEnd);
            });
            $('.myForm #exampleModal').modal();
        } else {
            $('.myForm #id').val('');
            $('.myForm #name').val('');
            $('.myForm #dateStart').val('');
            $('.myForm #dateEnd').val('');
            $('.myForm #exampleModal').modal();
        }
    });

});