function makeEditable(ajaxUrl) {
    $('#add').click(function () {
        $('#item_id').val(0);
        $('#editRow').modal();
    });

    $('.delete').click(function () {
        deleteRow($(this).attr("id"));
    });

    $('.edit').click(function () {
        $('#item_id').val($(this).attr("id"));
        $('#description').val($(this).attr("description"));
        $('#calories').val($(this).attr("calories"));
        $('#editRow').modal();
    })

    $('#detailsForm').submit(function () {
        save();
        return false;
    });

    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        failNoty(event, jqXHR, options, jsExc);
    });
}

function deleteRow(id) {
    $.ajax({
        url: ajaxUrl + id,
        type: 'DELETE',
        success: function () {
            updateTable();
            successNoty('Deleted');
        }
    });
}

function updateTable() {
    $.get(ajaxUrl, function (data) {
        oTable_datatable.fnClearTable();
        $.each(data, function (key, item) {
            oTable_datatable.fnAddData(item);
        });
        oTable_datatable.fnDraw();
    });
}

function save() {
    var frm = $('#detailsForm');
    debugger;
    $.ajax({
        type: "POST",
        url: ajaxUrl,
        data: frm.serialize(),
        success: function (data) {
            $('#editRow').modal('hide');
            updateTable();
            successNoty('Saved');
        }
    });
}

var failedNote;

function closeNote() {
    if (failedNote) {
        failedNote.close();
        failedNote = undefined;
    }
}

function successNoty(text) {
    closeNote();
    noty({
        text: text,
        type: 'success',
        layout: 'bottomRight',
        timeout: true
    });
}

function failNoty(event, jqXHR, options, jsExc) {
    closeNote();
    failedNote = noty({
        text: 'Failed: ' + jqXHR.statusText + "<br>",
        type: 'error',
        layout: 'bottomRight'
    });
}
