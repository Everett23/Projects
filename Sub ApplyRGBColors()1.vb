Sub ApplyRGBColors()
    Dim ws As Worksheet
    Dim r As Integer, g As Integer, b As Integer
    Dim rowIndex As Long, colIndex As Integer

    Set ws = ActiveSheet

    ' Loop through each column
    For colIndex = 1 To ws.Cells(1, ws.Columns.Count).End(xlToLeft).Column
        ' Loop through every third row in the column
        rowIndex = 1
        Do While rowIndex <= ws.Cells(ws.Rows.Count, colIndex).End(xlUp).Row - 2
            ' Read RGB values from three consecutive rows
            r = ws.Cells(rowIndex, colIndex).Value
            g = ws.Cells(rowIndex + 1, colIndex).Value
            b = ws.Cells(rowIndex + 2, colIndex).Value

            ' Apply color to the three rows based on the RGB values
            ws.Cells(rowIndex, colIndex).Resize(3, 1).Interior.Color = RGB(r, g, b)

            ' Move to the next group of three rows
            rowIndex = rowIndex + 3
        Loop
    Next colIndex
End Sub 
