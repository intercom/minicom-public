import json

from django.http import HttpResponse

def render_to_json(content, **kwargs):
  return HttpResponse(json.dumps(content), content_type='application/json', **kwargs)


def verify(request):
  return render_to_json({'success': True})