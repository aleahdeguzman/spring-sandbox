$(document).ready(function() {
	var ctx = $('#ctx').val();
	
	//radio button clicked - student details AJAX Request
	$('input:radio').change(function(){
		var number = $("input:radio:checked").val();
		
		
		$.getJSON(ctx+'/student/details/' + number, function(resp) {
			if (resp.status == '200') {
    			$('#studentDetailResp').text("Student Details: " + resp.student.studentNo + ' ' + resp.student.name + ' ' + resp.student.subject.subj_name);
    		} else {
    			$('#studentDetailResp').text("Error: " + resp.message);
    		}
    	});
	});
	
	//input button - delete student AJAX Request
	$('#deleteStudent').click(function(){
		var number = $("input:radio:checked").val();
		
		$.post(ctx+'/student/delete/' + number, function(resp) {
    		if (resp.status == '200') {
    			$('#studListTb').empty(); //remove student list created by jquery
    			$('#origStudTb').empty(); //remove original student list
    			
    			var tableStudent;
    			
    			$.each(resp.studentList, function(i,student){
    				tableStudent = $("#studListTb").append("<tr><td>" + student.studentNo + "</td>" +
    													   "<td>" + student.name + "</td>" +
    													   "<td>" + student.subject.subj_name + "</td>" +
    													   "<td><input type='radio' id='number' value='"+ student.studentNo + "'name='number'/></td></tr>");
    			});
    			
    			$('#studentDetailResp').empty();
    		} else {
    			$('#studentDetailResp').text("Error: " + resp.message);
    		}
    		
    	});
		
	});
	
	//submit button - add student AJAX Request
    $('#studentForm').submit(function(e){
    	$.post(ctx+'/student/', $(this).serialize(), function(resp) {
    		if (resp.status == '200') {
    			//update student list
    			$('#studListTb').empty(); //remove student list created by jquery
    			$('#origStudTb').empty(); //remove original student list
    			
    			var tableStudent;
    			
    			$.each(resp.studentList, function(i,student){
    				tableStudent = $("#studListTb").append("<tr><td>" + student.studentNo + "</td>" +
    													   "<td>" + student.name + "</td>" +
    													   "<td>" + student.subject.subj_name + "</td>" +
    													   "<td><input type='radio' id='number' value='"+ student.studentNo + "'name='number'/></td></tr>");
    			});
    			
    			$('#studentDetailResp').empty();
    		} else {
    			$('#studentDetailResp').text("Error: " + resp.message);
    		}
    		
    	});
    	e.preventDefault(); //prevent actual form submit and page reload
    });
    
});

function populateStudentTable(studentList) {
	alert("function called");
	$('#studListTb').empty(); //remove student list created by jquery
	$('#origStudTb').empty(); //remove original student list
	
	var tableStudent;
	
	$.each(studentList, function(i,student){
		tableStudent = $("#studListTb").append("<tr><td>" + student.studentNo + "</td>" +
											   "<td>" + student.name + "</td>" +
											   "<td>" + student.subject.subj_name + "</td>" +
											   "<td><input type='radio' id='number' value='"+ student.studentNo + "'name='number'/></td></tr>");
	});
	
	$('#studentDetailResp').empty();
}
