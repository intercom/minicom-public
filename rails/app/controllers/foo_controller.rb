class FooController < ApplicationController
  def verify
    render json: { success: true }
  end
end
