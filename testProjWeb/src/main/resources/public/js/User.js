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
        success: function(pResult){
            $('#list').html(pResult);
        }
    })
};

var userController = new UserController();

$('#submit').on("click",userController.saveUser);
$('#filter-button').on("click",userController.setFilter);

