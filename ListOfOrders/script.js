document.addEventListener('DOMContentLoaded', function () {
    // JavaScript code for handling button clicks and adding order data
    document.getElementById('createQuoteButton').addEventListener('click', function () {
        // Add your logic for creating a quote here
        if (confirm("Do you want to create  a new quote")) {
            window.location.href = ""
          } else {
            txt = "You pressed Cancel!";
          }
    });
    

    document.getElementById('logoutButton').addEventListener('click', function () {
        // Add your logic for logging out here
        if (confirm("Do you want to logout!!")) {
            window.location.href = "EmployeeLogin.html"
          } else {
            txt = "You pressed Cancel!";
          }
          
    });


    
    // You can dynamically add rows to the table with order data using JavaScript.
    // For example:
    var ordersData = [
        { orderId: '1', customerName: 'Akshita Singh', orderDate: '2023-09-10', orderValue: '5000', customerCity: 'New Delhi', status: 'Pending' },
        { orderId: '2', customerName: 'Aditya Verma', orderDate: '2023-08-11', orderValue: '1000', customerCity: 'Lucknow', status: 'Completed' },

        // Add more order data objects here
    ];
    
    var tbody = document.getElementById('orderTableBody');
    ordersData.forEach(function (order) {
        var row = document.createElement('tr');
        row.innerHTML = `
            <td>${order.orderId}</td>
            <td>${order.customerName}</td>
            <td>${order.orderDate}</td>
            <td>${order.orderValue}</td>
            <td>${order.customerCity}</td>
            <td>${order.status}</td>
            <td><button class="openInvoiceBtn" OnClick=" location.href='' ">Open</button></td>
        `;
        tbody.appendChild(row);
    });
    // function invoice {
    //     window.location='EmployeeLogin.html';
    // }
});


