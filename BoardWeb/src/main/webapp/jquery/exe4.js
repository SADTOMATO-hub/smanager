/**
 *  exe4
 */

$(document).ready(function() {
		$('#addSelected').on('click', function() {
			let newTr = $('<tr />').append(
				$('<td />').append($('<input>').attr('type', 'radio').attr('name', 'choice'))
				, $('<td />').html($('#userId').val())
				, $('<td />').html($('#userName').val())
				, $('<td />').html($('#userAge').val())
			);
			let target = $('tbody input[type="radio"]:checked').parent().parent()
			console.log(target)
			target.after(newTr);
		}) //end of addSelected
		$('#clone').on('click',function(){
			
		})//end of clone
	}) //end of document