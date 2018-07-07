    <?php
    // Get required files.
    require 'fpdf/fpdf.php';
     
    // Set some document variables
    $author = "Me McMe";
    $company_name = "APPLIED MATERIALS";
    $name = "Liang Y. Chen, Ph.D.";
    $title = "Corporate Vice President & General Manager";
    $title_2 = "Alternative Energy Products Group";
    $dept_div = "Energy & Environmental Solutions";
    $phone = "T  408.563.6330";
    $fax = "F  408.235.6989";
    $email = "Liang_Chen@amat.com";
    $address2 = '3535 Garrett Drive, M/S 10071fdsfsdf';
     
    // Create fpdf object
    $pdf = new FPDF('L', 'mm', array(51,87)); //fpdf(orientation(L for Landscape), unit of measurement(mm for millimeters),
     
    // Add a new page to the document
    $pdf->addPage('L', array(51,87));
     
    $pdf->SetDisplayMode(real,'two');
    $pdf->SetFont('Arial','B',5);
    $pdf->SetTextColor(0,0,0);
    $pdf->SetXY(0, 0);
    $pdf->SetMargins(0,0,0);
     
    $pdf->Cell(0,11, "$company_name", '1', 2, 'L', false);
    $pdf->Cell(0,11, "$name", '1', 2, 'L', false);
    $pdf->Cell(0,11, "$title", '1', 2, 'L', false);
    $pdf->Cell(0,11, "$title_2", '1', 2, 'L', false);
    $pdf->Cell(0,11, "$dept_div", '1', 2, 'L', false);
    $pdf->Cell(0,11, "$phone", '1', 2, 'L', false);
    $pdf->Cell(0,11, "$fax", '1', 2, 'L', false);
    $pdf->Cell(0,11, "$email", '1', 2, 'L', false);
    $pdf->Cell(0,11, "$address2", '1', 2, 'L', false);
     
    $pdf->Image('amatlogo.gif', 0, 0, 23.28, 21.52, 'GIF');
    $pdf->Output('simple.pdf','I');
    ?>
