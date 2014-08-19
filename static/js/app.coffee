$ ->
	$document = $(document)
	$window = $(window)

	mydata = []

	process_raw = (string) ->
		processed = string.replace /job\.php/, "http://dignityhealth.org/careers/jobs/job.php"
		processed = processed.replace /class=/, "target=\"_blank\" class="
		Reactable.unsafe(processed)

	for job, i in window.tblDataRows
		mydata[i] = {
			title: process_raw(job.title)
			location: process_raw(job.location)
			shift: process_raw(job.shift)
		}

	$demo_table = $('#demo-table')

	if $demo_table.length > 0
		React.renderComponent(
			Reactable.Table({
				data: mydata
				itemsPerPage: 20
				sortable: ['title', 'location', 'shift']
				filterable: ['title', 'location', 'shift']
			}),
			$demo_table[0]
		)
		$demo_table.find('table').addClass('table table-striped')
		$demo_table.find('.reactable-filterer td').prepend('<label class="filter-label">Filter</label>')
		$demo_table.find('.reactable-filterer td input').addClass('form-control').wrap('<div class="col-xs-3"/>')

	true