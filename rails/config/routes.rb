Rails.application.routes.draw do
  post "foo", to: "foo#verify"
  post "bar", to: "bar#verify"
end
