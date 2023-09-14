document.addEventListener('DOMContentLoaded', function () {
    // JavaScript code for handling button clicks and adding order data
    document.getElementById('createQuoteButton').addEventListener('click', function () {
        // Add your logic for creating a quote here
        if (confirm("Do you want to create  a new quote")) {
            window.location.href = "List_quotes.html"
          } else {
            txt = "You pressed Cancel!";
          }
    });
    

    document.getElementById('importQuoteButton').addEventListener('click', function () {
      // Add your logic for creating a quote here
      if (confirm("Do you want to import the product")) {
          window.location.href = "json_upload.html"
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
        { orderId: '101', customerName: 'Anchal Chand', orderDate: '2023-09-08', orderValue: '105000', customerCity: 'Pune', status: 'Completed' },
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
            <td><button class="openInvoiceBtn" OnClick=" location.href='invoice_1.html' ">Open</button></td>
        `;
        tbody.appendChild(row);
    });
    // function invoice {
    //     window.location='EmployeeLogin.html';
    // }
});


