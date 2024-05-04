$(document).ready(function() {
    $('#szukaj').keyup(function() {
        var searchText = $(this).val().toLowerCase();
        $.ajax({
            url: 'window.location.pathname',
            method: 'GET',
            dataType: 'html',

            success: function(data) {
                $('#wrap section').each(function() {
                    var articleText = $(this).find('h2').text().toLowerCase();
                    var parentSection = $(this);

                    if (articleText.indexOf(searchText) === -1) {
                        parentSection.hide();
                    } else {
                        parentSection.show();
                    }
                });
            },
            error: function(xhr, status, error) {
                console.log("Error: " + error);
            }
        });
    });
});