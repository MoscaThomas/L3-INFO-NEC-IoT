<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>IoT </title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.6.2/chart.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<div class="rectangle">
    <div class="graph">

        <canvas id="myChart"></canvas>
        <script>
        var ctx = document.getElementById('myChart').getContext('2d');
        var myChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: [],
                datasets: [{
                    label: 'Prix',
                    data: [],
                    backgroundColor: 'rgba(255, 99, 132, 0.2)',
                    borderColor: 'rgba(255, 99, 132, 1)',
                    borderWidth: 2
                }]
            },

        });
        function getData() {
            $.ajax({
                url: 'data.php', // chemin du script PHP qui va récupérer les données
                method:'GET',
                
                success: function(response) {
                    var data = JSON.parse(response);
                    myChart.data.labels.push(data.id);
                    myChart.data.datasets[0].data.push(data.prix);
                    myChart.update();
                    
                }
            });
        }

        setInterval(getData, 5000);
        
    </script>
    </div>
</div>
</body>
</html>