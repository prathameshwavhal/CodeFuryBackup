// document.addEventListener('DOMContentLoaded', function () {
//     // JavaScript code for handling button clicks and adding order data
//     document.getElementById('createQuoteButton').addEventListener('click', function () {
//         // Add your logic for creating a quote here
//         if (confirm("Do you want to create  a new quote")) {
//             window.location.href = ""
//           } else {
//             txt = "You pressed Cancel!";
//           }
//     });

//     document.getElementById('logoutButton').addEventListener('click', function () {
//         // Add your logic for logging out here
//         if (confirm("Do you want to logout!!")) {
//             window.location.href = "EmployeeLogin.html"
//           } else {
//             txt = "You pressed Cancel!";
//           }
          
//     });

//     // You can dynamically add rows to the table with order data using JavaScript.
//     // For example:
    
// });

function approve()
{
  // route to page here
  // window.location = newUrl;
  // console.log("Button Clicked2.")
}

function showInvoice()
{
  // route to page here
  // window.location = newUrl;
  // console.log("Button Clicked.")
  window.location='invoice_1.html'
}

var quotesData = [
  { orderId: '1003', orderDate: '2023-09-10', shippingCost: '500', orderValue: '5000' },
  { orderId: '1004', orderDate: '2023-08-11', shippingCost: '100', orderValue: '1000' },

  // Add more order data objects here
];

var tbody = document.getElementById('quoteTableBody');
quotesData.forEach(function (quote) {
  var row = document.createElement('tr');
  row.innerHTML = `
      <td>${quote.orderId}</td>
      <td>${quote.orderDate}</td>
      <td>${quote.shippingCost}</td>
      <td>${quote.orderValue}</td>
      <td style="text-align:center;"><button class="quote-button" onClick="approve()">Approve</button></td>
  `;
  tbody.appendChild(row);
});

var ordersData = [
  { orderId: '101', orderDate: '2023-09-08', shippingCost: '0', orderValue: '105000', status:'Approved' },
  { orderId: '1002', orderDate: '2023-05-25', shippingCost: '100', orderValue: '1000', status: 'Approved' },

  // Add more order data objects here
];

var tbody2 = document.getElementById('orderTableBody');
ordersData.forEach(function (order) {
  var row = document.createElement('tr');
  row.innerHTML = `
      <td>${order.orderId}</td>
      <td>${order.orderDate}</td>
      <td>${order.shippingCost}</td>
      <td>${order.orderValue}</td>
      <td>${order.status}</td>
      <td style="text-align:center;"><button class="quote-button" onClick="showInvoice()">Show Invoice</button></td>
  `;
  tbody2.appendChild(row);
});