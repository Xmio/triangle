## Triangle

### First I created a triangular array with zeros and initialize the bottom row with the same values as the original triangle.

	2          0
	1 3        0 0
	4 2 2      0 0 0
	3 2 4 1	   3 2 4 1

### After that I checked the smallest consecutive numbers based on the previews lane and set to the above row.

	2          0
	1 3        0 0
	4 2 2      2 2 1
	3 2 4 1    3 2 4 1

### Next step was add to this positions all the original number of this row

	2          0
	1 3        0 0
	4 2 2      6 4 3
	3 2 4 1    3 2 4 1

### After that I checked the smallest consecutive numbers based on the previews lane and set to the above row.

	2          0
	1 3        4 3
	4 2 2      6 4 3
	3 2 4 1    3 2 4 1

### Next step was add to this positions all the original number of this row

	2          0
	1 3        5 6
	4 2 2      6 4 3
	3 2 4 1    3 2 4 1


### And concluding with the same in the last row

	2          7
	1 3        5 6
	4 2 2      6 4 3
	3 2 4 1    3 2 4 1

