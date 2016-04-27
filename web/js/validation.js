
$(document).ready(function () {

    /**
     * Add Building
     */
    $('#addbuildingform').validate({
        rules: {
            buildingName: {
                required: true,
                minlength: 3,
                maxlength: 50
            },
            ownerName: {
                required: true,
                minlength: 3,
                maxlength: 50
            },
            buildingAddress: {
                required: true,
                minlength: 3,
                maxlength: 50
            },
            buildingCity: {
                required: true,
                minlength: 3,
                maxlength: 50
            },
            buildingZipcode: {
                required: true,
                digits: true,
                minlength: 4,
                maxlength: 4
            },
            buildingYear: {
                required: true,
                digits: true,
                minlength: 4,
                maxlength: 4
            },
            nrOfFloors: {
                required: true,
                number: true,
                step: 1,
                min: -20,
                max: 500
            },
            totalM2: {
                required: true,
                number: true,
                minlength: 1,
                maxlength: 20,
                min: 1,
                max: 999999
            },
            conditionLevel: {
                required: true,
                digits: true,
                minlength: 1,
                maxlength: 1,
                min: 0,
                max: 3
            }
        },
        highlight: function (element) {
            $(element).closest('.form-group').addClass('has-error');
        },
        unhighlight: function (element) {
            $(element).closest('.form-group').removeClass('has-error');
        },
        errorElement: 'span',
        errorClass: 'help-block'
    });

});