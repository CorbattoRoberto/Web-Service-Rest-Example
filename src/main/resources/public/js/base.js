function deleteCustomer(idCustomer) {
    if (confirm("Sei sicuro di voler cancellare questo cliente?")) {
        console.log("ID customer da cancellare: " + idCustomer);

        // Esegui la cancellazione solo se l'utente ha confermato
        CustomerService.delete(idCustomer).then(function() {
            getAll();
        });
    }
}

function editCustomer(id, firstName, lastName) {
	document.getElementById("nomeCustomer").value = firstName;
	$('#cognomeCustomer').val(lastName);
	document.getElementById("idCustomer").value = id;
}

function getAll() {
	$('#tableCustomers tbody tr').remove();
	
    CustomerService.getAll()
        .then(function(customerList) {
            $.each(customerList, function(i, customer) {
                $('#tableCustomers tbody')
                .append('<tr>'
                + '<td>' + customer.id + '</td><td>' + customer.firstName + '</td><td>' + customer.lastName + '</td>'
                + '<td>' + customer.address + '</td><td>' + customer.city + '</td><td>' + customer.email + '</td>'
                + '<td><div onclick="deleteCustomer(' + customer.id + ')"><span class="material-symbols-outlined">delete</span></div></td><td><div onclick="editCustomer(' + customer.id + ', \'' + customer.firstName + '\', \'' + customer.lastName + '\')"><span class="material-symbols-outlined">edit</span></div></td></tr>');
            })
        })

    document.getElementById("idCustomer").value=0;
}

$(document).ready(function () {
	
    $('#showCustomers').click(function () {
        $('#tableCustomers tbody')
        	.append('<tr><td>1</td><td>Nome Statico</td><td>Cognome Statico</td><td>Indirizzo</td><td>Città</td><td>Email</td><td>--</td><td>--</td></tr>');
    });
    
    $('#showCustomersAPI').click(function () {
		getAll();	
    });
    
    $('#btnSaveCustomer').click(function () {
	
		var id = document.getElementById("idCustomer").value;
		var nome = document.getElementById("nomeCustomer").value;
		var cognome = $('#cognomeCustomer').val();
		
		console.log("Id: " + id);
		console.log("Nome: " + nome);
		console.log("Cognome: " + cognome);
		
		var formData = JSON.stringify({
			'id': Number(id),
			'firstName': nome,
			'lastName': cognome,
			'address' : 'address modified by html page',
            'city' : 'city modified by html page',
            'email' : 'modified@testmail.com'
		});
		
		console.log(formData);
		console.log(id);
		console.log(Number(id));
		if (Number(id) > Number(0)) {
			
			console.log('IF');
			CustomerService.put(formData).then(function() {
				getAll();
			});
		} else {
			
			console.log('ELSE');
			CustomerService.post(formData).then(function() {
                getAll();
            });
		}
		
		document.getElementById("idCustomer").value=0;
		document.getElementById("nomeCustomer").value="";
		document.getElementById("cognomeCustomer").value="";
	});

});
