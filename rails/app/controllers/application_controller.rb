class ApplicationController < ActionController::Base
  # Prevent CSRF attacks by raising an exception.
  # For APIs, you may want to use :null_session instead.
  protect_from_forgery with: :exception
  helper_method :current_admin

  skip_before_action :verify_authenticity_token
  before_action :set_headers

  def set_headers
    headers['access-control-allow-origin'] = '*'
  end

  # Let's pretend we have logins, sessions and so on.
  def current_admin
    "you@intercom.io"
  end
end
