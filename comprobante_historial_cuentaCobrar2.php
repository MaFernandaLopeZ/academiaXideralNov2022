<!DOCTYPE html>
<html>

<head>
    <?php
    require_once('shared/head.php');
    ?>
    <meta charset="UTF-8" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.6/jspdf.plugin.autotable.min.js"></script>

    <script src="js/moment.min.js"> </script>

    <?php
    $params = $_REQUEST;
    $id_cliente = $params['id'];
    echo "  <script>var id_cliente=" . $id_cliente . ";
                var opcion='';
        </script>";

    ?>

    <style>
        * {
            font-size: 15px;
            font-family: 'Arial';
        }

        .ticket {
            width: 500px;
        }

        img {
            width: 250px;
        }
    </style>
</head>

<body>
    <div class="ticket" id="ticket">
        <img src="image/mariate-original.png" alt="Logotipo">

        <p id="nombre"></p>
        <p id="ciudad"></p>
        <p id="telefono"></p>

        <table id="table" class="table table-colapse">
            <thead>
                <tr>
                    <th colspan="2">Documento</th>
                    <th rowspan="2">Proceso</th>
                    <th rowspan="2">Débito</th>
                    <th rowspan="2">Crédito</th>
                    <th rowspan="2">Balance</th>
                </tr>
                <tr>
                    <th>Número</th>
                    <th>Fecha</th>
                </tr>
            </thead>
            <tbody id="detalles">
            </tbody>
        </table>

        <table id="table2" style="width: 50%">

            <tbody>
                <tr>
                    <td>Ventas</td>
                    <td id="ventas" style="text-align: center;"></td>
                </tr>
                <tr>
                    <td>Pagos</td>
                    <td id="pagos" style="text-align: center;"></td>
                </tr>
                <tr>
                    <td>Notas a créditos</td>
                    <td id="notas_credito" style="text-align: center;"></td>
                </tr>
                <tr>
                    <td>Notas a débito</td>
                    <td id="notas_debito" style="text-align: center;"></td>
                </tr>
                <tr>
                    <td>Balance</td>
                    <td id="balance" style="text-align: center;"></td>
                </tr>
            </tbody>
        </table>
    </div>


    <script>
        var tam_detalles = 0;
        function getNumber(num) {
            var number = Number(num.replace(/[^0-9\.]+/g, ""));
            return number;
        }

        function getFormatoMoneda(num) {
            const formatter = new Intl.NumberFormat('en-US', {
                style: 'currency',
                currency: 'USD',
                minimumFractionDigits: 2
            });
            return formatter.format(num);
        }

        $.ajax({
            type: "GET",
            url: './php/clientes.php?action=get_historial&id_cliente=' + id_cliente,
            success: function(response) {
                var response = JSON.parse(response);
                console.log(response);
                $('#nombre').text(response.cliente);
                $('#ciudad').text(response.direccion);
                $('#telefono').text(response.telefono);

                $.each(response.detalles, function(index, tema) {
                    if (response.detalles[index] != 0) {

                        for(var i = 0 ; i<10 ; i++){
                        // hay registro
                        tr = $('<tr/>');
                        tr.append("<td>" + tema.numero + "</td>");
                        tr.append("<td>" + tema.fecha + "</td>");
                        tr.append("<td>" + tema.proceso + "</td>");
                        tr.append("<td>" + tema.debito + "</td>");
                        tr.append("<td>" + tema.credito + "</td>");
                        tr.append("<td>" + tema.balance + "</td>");

                        $('#detalles').append(tr);
                        }

                    }
                    tam_detalles = index + 1;
                });
                
                tr = $('<tr/>');
                tr.append("<td colspan='4'> </td>");
                tr.append("<td> Balance </td>");
                tr.append("<td>" + response.balance + "</td>");
                $('#detalles').append(tr);

                $('#ventas').text(response.total_ventas);
                $('#pagos').text(response.total_pagos);
                $('#notas_credito').text(response.notas_credito);
                $('#notas_debito').text(response.notas_debito);
                $('#balance').text(response.balance);

                getTicket();
            }
        });

        function getTicket() {
            const doc = new jsPDF({
                format: "letter"
            });

            var img = new Image();
            img.src = 'image/mariate-original.png';
            
            var totalPagesExp = '{total_pages_count_string}'

            var tabla = '#table';

            doc.autoTable({
                html: tabla,
                theme: 'plain',
                styles: {
                    halign: 'center',
                },
                willDrawCell: function(data) {
                    if (data.row.index == tam_detalles) {
                        doc.setFontSize(10);
                        doc.setFontStyle('bold');
                    }
                },
                headStyles: {
                    // fillColor: '#013365',
                    fillColor: [171, 65, 147],
                    textColor: [255, 255, 255],
                    valign: 'bottom',
                },
                didDrawPage: function(data) {
                    // Header
                    doc.addImage(img, 'png', 85, 10, 50, 26);
                    doc.setFontSize(8);
                    doc.text('Ave. Juan P.Duarte, Plaza Zona Rosa', 86, 40);
                    doc.text('Santiago de los caballeros', 93, 45);
                    doc.setFontSize(10);
                    doc.setFontStyle('bold');
                    doc.setTextColor('#004C99');
                    doc.text('ESTADO DE CUENTA', 92, 53);
                    doc.text('Hasta ' + moment().format('DD/MM/YYYY'), 96, 58);

                    doc.setTextColor('#00000');
                    doc.text(15, 65, "" + $("#nombre").text() + "");
                    doc.text(15, 70, "" + $("#ciudad").text() + "");
                    doc.text(15, 75, "" + $("#telefono").text() + "");

                    doc.setFont("helvetica");
                    doc.setFontType("normal");
                    doc.setFontSize(12);

                    // paginas
                    doc.setFontSize(10);
                    var str = 'Página ' + doc.internal.getNumberOfPages()
                    if (typeof doc.putTotalPages === 'function') {
                        str = str + ' / ' + totalPagesExp;
                    }
                    doc.text(str, 10, 10);
                },
                margin: {
                    top: 80
                }
            });

            doc.autoTable({
                html: '#table2',
                theme: 'plain',
                styles: {
                    halign: 'right',
                    fontStyle: 'bold'
                },
                margin: {
                    left: 15,
                    right: 140
                },
                columnStyles: {
                    0: {
                        halign: 'left'
                    },
                    1: {
                        halign: 'center'
                    }
                }
            });

            if (typeof doc.putTotalPages === 'function') {
                doc.putTotalPages(totalPagesExp);
            }

            // window.close();

            // doc.autoPrint({variant: 'non-conform'});
            window.open(URL.createObjectURL(doc.output("blob")), '', 'width=800,height=500,left = 300,top = 100');
        }
    </script>
</body>

</html>