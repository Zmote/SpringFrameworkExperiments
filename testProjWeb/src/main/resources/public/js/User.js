/**
 * Created by Zmote on 30.10.2016.
 */


function UserController(){
}

UserController.prototype.saveUser = function(){
    var form = $('#newUserForm');
    $.ajax({
        url:"/users",
        method: "POST",
        data: form.serialize(),
        cache:false,
        success: function(pResult){
            $('#list').html(pResult);
        }
    })
};

UserController.prototype.setFilter = function () {
  var ageFilter = $('#ageFilter').val();
    $.ajax({
        url:"/users",
        method: "GET",
        data: "ageFilter=" + ageFilter,
        cache:false,
        success: function(pResult){
            $('#list').html(pResult);
        }
    })
};

UserController.prototype.assignRole = function () {
    var selectedRole = $( "#roleSelect").find("option:selected" ).text();
    var selectedUserId = $(this).parent().parent().find("input").val();
    $.ajax({
        url:"/users/" + selectedUserId,
        method: "POST",
        data: "role=" + selectedRole,
        cache:false,
        success: function(pResult){
            $("#list").html(pResult);
        }
    })
};

var userController = new UserController();

$('#submit').on("click",userController.saveUser);
$('#filter-button').on("click",userController.setFilter);
$('body').on("click",".js-assignRole",userController.assignRole);

