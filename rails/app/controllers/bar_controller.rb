class BarController < ApplicationController
  def verify
    render json: { success: true }
  end
end
